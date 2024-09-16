package com.palmyralabs.interview.assembly;

import java.io.IOException;
import java.util.List;

import com.opencsv.exceptions.CsvValidationException;
import com.palmyralabs.interview.assembly.csv.TaskReader;
import com.palmyralabs.interview.assembly.pojo.TaskGroup;
import com.palmyralabs.interview.assembly.pojo.TaskInfo;

public class MainApp {
	public static void main(String[] args) throws CsvValidationException, IOException {
		TaskReader reader = new TaskReader();
		List<TaskInfo> tasks = reader.readFile("input/bike.csv");
		
		List<TaskGroup> result = new Calculator().process(tasks);
		
		print(result);
	}

	private static void print(List<TaskGroup> result) {
		for (TaskGroup tg : result) {
			System.out.print(tg.getGroup() + ",");
			int count = 0;
			for (TaskInfo ti : tg.getTasks()) {
				count += ti.getAverageTime();
				System.out.print(ti.getTaskName() + " ");
			}
			System.out.println("," + count);
		}
	}
}
