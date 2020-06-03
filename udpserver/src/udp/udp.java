package udp;

import java.net.DatagramSocket;

public class udp {

}
class test{
	 private InetAddress ipaddress;
	    private Integer port;
	    private Socket client_socket;
	    private InetAddress comm_ip;
	    private DatagramSocket comm_skt;
	    private DatagramPacket comm_pkt;
	    private int comm_port;
	    private byte status;
	DatagramSocket datagram_server_socket;
	public void init() {
	    DatagramSocket datagram_server_socket = new DatagramSocket(port,local_addr);
	    datagram_server_socket.setSoTimeout(1000);
	}
	public void connect() {
	    Random r = new Random(System.currentTimeMillis());
	    int udp_port = 0;
	    while(true){
	        try {
	            udp_port = r.nextInt(1000)+8000;
	            udp_port = 8000;
	            comm_skt = new DatagramSocket(udp_port);
	            Log.i("ServerWrapper", "UDP Listening on port: " + udp_port);
	            break;
	        } catch(SocketException e) {
	            Log.e("ServerWrapper", "Could not bind to port " + udp_port);
	        }
	    }
	    byte[] sdata = new byte[4+tid.length];
	    i = 0;
	    sdata[i++] = (byte)(0XFF&(udp_port>>24));
	    sdata[i++] = (byte)(0XFF&(udp_port>>16));
	    sdata[i++] = (byte)(0XFF&(udp_port>>8));
	    sdata[i++] = (byte)(0XFF&(udp_port));
	    for(byte b: tid){
	        sdata[i++] = b;
	    }
	    DatagramPacket pkt = new DatagramPacket(sdata, sdata.length, 
	                                InetAddress.getByName(hostname), port);
	    comm_skt.send(pkt);
	}
}
public void serverUDPListener() {
    try {
        datagram_server_socket.receive(rpkt);
        int port = 0;
        byte[] rdata = rpkt.getData();
        port += rdata[0]<<24;
        port += rdata[1]<<16;
        port += rdata[2]<<8;
        port += (0XFF)&rdata[3];
        byte[] tid = new byte[rdata.length];
        for(int i = 4; i < rdata.length && rdata[i] > 0; i++) {
            tid[i-4] = rdata[i];
        }
        String thread_id = new String(tid).trim();
        for(int i = 0; i < threads.size(); i++) {
        ClientThread t = threads.get(i);
        if(t.getThreadId().compareTo(thread_id) == 0) {
            t.setCommSocket(rpkt, port);
        } else {
            System.err.println("THREAD ID " + thread_id + " COULD NOT BE FOUND");
        }
        }
    } catch (IOException e) {
        if(!(e instanceof SocketException) && !(e instanceof SocketTimeoutException))
        log.warning("Error while listening for an UDP Packet.");
    }
}

我在这个网站上阅读了很多关于如何在Android中接收UDP数据包的帖子。但是，这对我来说都不起作用！

一些基础知识：

我正在测试运行在3G上的HTC Incredible（Android 2.2）（不是wifi或其他任何东西）。这里不涉及模拟器。

我的代码很简单：

我的服务器（在我的PC上运行）正在侦听端口8752上的UDP流量。
我的Android应用程序在随机端口上打开一个DatagramSocket，并使用此端口将数据包发送到我的服务器。
然后我保存此信息（InetAddress形成接收的数据包和数据包中找到的端口）。
我尝试从我的服务器（再次，在我的电脑上）发送UDP数据包到我的Android应用程序（在我的手机上运行），它不起作用。
//Server code to initialize the UDP socket (snippet)
public void init() {
    datagram_server_socket = new DatagramSocket(port,local_addr);
    datagram_server_socket.setSoTimeout(1000);
}
// ANDROID APP上的代码片段，用于将数据包发送到服务器

public void connect() {
    Random r = new Random(System.currentTimeMillis());
    int udp_port = 0;
    while(true){
        try {
            udp_port = r.nextInt(1000)+8000;
            udp_port = 8000;
            comm_skt = new DatagramSocket(udp_port);
            Log.i("ServerWrapper", "UDP Listening on port: " + udp_port);
            break;
        } catch(SocketException e) {
            Log.e("ServerWrapper", "Could not bind to port " + udp_port);
        }
    }
    byte[] sdata = new byte[4+tid.length];
    i = 0;
    sdata[i++] = (byte)(0XFF&(udp_port>>24));
    sdata[i++] = (byte)(0XFF&(udp_port>>16));
    sdata[i++] = (byte)(0XFF&(udp_port>>8));
    sdata[i++] = (byte)(0XFF&(udp_port));
    for(byte b: tid){
        sdata[i++] = b;
    }
    DatagramPacket pkt = new DatagramPacket(sdata, sdata.length, 
                                InetAddress.getByName(hostname), port);
    comm_skt.send(pkt);
}
//Server's UDP socket listening code
public void serverUDPListener() {
    try {
        datagram_server_socket.receive(rpkt);
        int port = 0;
        byte[] rdata = rpkt.getData();
        port += rdata[0]<<24;
        port += rdata[1]<<16;
        port += rdata[2]<<8;
        port += (0XFF)&rdata[3];
        byte[] tid = new byte[rdata.length];
        for(int i = 4; i < rdata.length && rdata[i] > 0; i++) {
            tid[i-4] = rdata[i];
        }
        String thread_id = new String(tid).trim();
        for(int i = 0; i < threads.size(); i++) {
        ClientThread t = threads.get(i);
        if(t.getThreadId().compareTo(thread_id) == 0) {
            t.setCommSocket(rpkt, port);
        } else {
            System.err.println("THREAD ID " + thread_id + " COULD NOT BE FOUND");
        }
        }
    } catch (IOException e) {
        if(!(e instanceof SocketException) && !(e instanceof SocketTimeoutException))
        log.warning("Error while listening for an UDP Packet.");
    }
}
//Corresponds to the setCommSocket call above to save the IP and Port of the incoming UDP packet on the server-end
public void setCommSocket(DatagramPacket pkt, int port) {
    comm_ip = pkt.getAddress();
    comm_port = pkt.getPort(); //Try the port from the packet?
}
//Sends an UDP packet from the SERVER to the ANDROID APP
public void sendIdle() {
    if(comm_ip != null) {
        System.err.println("Sent IDLE Packet (" + comm_ip.getHostAddress() + ":" + comm_port + ")");
        DatagramPacket spkt = new DatagramPacket(new byte[]{1, ProtocolWrapper.IDLE}, 2, comm_ip, comm_port);
        DatagramSocket skt;
        try {
            skt = new DatagramSocket();
            skt.send(spkt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
public void AndroidUDPListener() {
    while(true) {
        synchronized(stop) {
        if(stop) return;
        }
        byte[] recieve_data = new byte[64];
        DatagramPacket rpkt = new DatagramPacket(recieve_data, recieve_data.length);
        try {
        if(comm_skt == null) 
                continue;
        comm_skt.receive(rpkt);
        byte[] data = rpkt.getData();
        switch(data[1]) {
            case IDLE:
            if(ocl != null) ocl.onCompletion(null);
            break;
            case KEEP_ALIVE:
            break;
        }
        } catch (Exception e) {
        if(!(e instanceof SocketException) && !(e instanceof SocketTimeoutException))
                Log.w("ServerWrapper", "Error while listening for an UDP Packet.");
        }
    }
}