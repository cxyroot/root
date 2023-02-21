package kafka;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class DistributeClient {
	private static String connectString = "192.168.34.102:2181,192.168.34.103:2181,192.168.34.104:2181";
	
	private static int sessionTimeout = 2000;
	private ZooKeeper zk = null;
	private String parentNode = "/servers";

	// ������zk�Ŀͻ�������
	public void getConnect() throws IOException {
		Watcher watcher =  new Watcher() {

			public void process(WatchedEvent event) {
				// �ٴ���������
				try {
					getServerList();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		};
		
		
		zk = new ZooKeeper(connectString, sessionTimeout,watcher,Boolean.TRUE);
	}

	// ��ȡ�������б���Ϣ
	public void getServerList() throws Exception {

		// 1��ȡ�������ӽڵ���Ϣ�����ҶԸ��ڵ���м���
		List<String> children = zk.getChildren(parentNode, true);

		// 2�洢��������Ϣ�б�
		ArrayList<String> servers = new ArrayList<String>();

		// 3�������нڵ㣬��ȡ�ڵ��е�����������Ϣ
		for (String child : children) {
			byte[] data = zk.getData(parentNode + "/" + child, false, null);

			servers.add(new String(data));
		}

		// 4��ӡ�������б���Ϣ
		System.out.println(servers);
	}

	// ҵ����
	public void business() throws Exception {

		System.out.println("client is working ...");
		Thread.sleep(Long.MAX_VALUE);
	}

	public static void main(String[] args) throws Exception {

		// 1��ȡzk����
		DistributeClient client = new DistributeClient();
		client.getConnect();

		// 2��ȡservers���ӽڵ���Ϣ�����л�ȡ��������Ϣ�б�
		client.getServerList();

		// 3ҵ���������
		client.business();
	}

}