package test.sync2;

public class RunSync2 {

	public static void main(String[] args) {
		Buffer buf = new Buffer();
		Producer producer = new Producer(buf);
		Consumer consumer = new Consumer(buf);
		producer.start();
		consumer.start();
	}

}
