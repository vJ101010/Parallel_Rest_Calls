package com.poc.ParallelProgramming.restAPIs;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.nimsoft.events.api.model.AlarmsResult;
import com.nimsoft.events.api.model.filter.AlarmFilter;
import com.nimsoft.events.client.EmsClient;
import com.nimsoft.events.client.EmsClientFactory;
import com.nimsoft.nimbus.NimConfig;
import com.nimsoft.nimbus.NimException;
import com.poc.ParallelProgramming.MyThread;

public class EMSRestCalls {

	private static final String EMS_GET_ALARMS_URL = "http://10.131.141.44:80/rest/alarms";

	public static void main(String[] args) throws InterruptedException, NimException {
		String userName = args[0];
		String password = args[1];

		//getEmsClinet();
		 invokeParallelThreads(userName, password);
	}

	private static void getEmsClinet() throws NimException {
		EmsClient emsClient = EmsClientFactory.resolveEmsClient("/m1/s1-nms1/s1-nms1/ems", "/m1/s1-nms1/s1-nms1/trellis",
				Locale.ENGLISH);
		System.out.println(emsClient);
		AlarmFilter alarmFilter = new AlarmFilter();
		alarmFilter.setIncludeHidden(true);
		AlarmsResult alarms = emsClient.getAlarms(alarmFilter);
		System.out.println(alarms.getAlarms());

	}

	private static void invokeParallelThreads(String userName, String password) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(20);
		MyThread myThread = new MyThread(EMS_GET_ALARMS_URL, userName, password);
		for (int index = 0; index < 4; index++) {
			Thread.sleep(2000);
			for (int i = 0; i < 5; i++) {
				executorService.execute(myThread);
			}
		}
		// System.exit(0);
	}
}
