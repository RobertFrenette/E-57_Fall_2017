package edu.hes.e57.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorkerBean {
	private static Logger logger = LoggerFactory.getLogger(WorkerBean.class);

	public void doSomeWork(int noOfTimes) {
		for (int x = 0; x < noOfTimes; x++) {
			work();
		}
	}

	private void work() {
		logger.info("");
	}
}
