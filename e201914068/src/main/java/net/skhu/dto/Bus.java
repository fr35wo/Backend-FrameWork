package net.skhu.dto;

import lombok.Data;

@Data
public class Bus {
	int id;
	String busNo;
	String firstStop;
	String lastStop;
	int categoryId;
	String firstBus;
	String lastBus;

	String categoryName;
}
