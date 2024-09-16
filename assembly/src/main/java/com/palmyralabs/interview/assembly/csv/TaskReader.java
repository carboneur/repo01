package com.palmyralabs.interview.assembly.csv;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.palmyralabs.interview.assembly.pojo.TaskInfo;

public class TaskReader {
	public List<TaskInfo> readFile(String file) throws IOException, CsvValidationException {
		CSVReader csvReader = new CSVReader(new FileReader(file));
		ArrayList<TaskInfo> result = new ArrayList<TaskInfo>();
		String[] values = null;
		while ((values = csvReader.readNext()) != null) {
			TaskInfo info = convert(values);
			if (null != info)
				result.add(info);
		}

		csvReader.close();
		return result;
	}

	private TaskInfo convert(String[] values) {
		TaskInfo result = new TaskInfo();
		if (values.length < 3)
			return null;

		result.setTaskName(values[0]);
		result.setAverageTime(Integer.parseInt(values[1]));
		result.setDeviation(Integer.parseInt(values[2]));
		return result;
	}
}
