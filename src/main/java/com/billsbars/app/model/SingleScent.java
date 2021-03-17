package com.billsbars.app.model;

import lombok.Data;

@Data
public class SingleScent {
	
	private BaseScents baseScent;
	private int drops;
	
	public SingleScent() {}
	public SingleScent(BaseScents baseScent, int drops) {
		this.baseScent = baseScent;
		this.drops = drops;
				
	}

	public SingleScent(String val, int drops) {
		this.baseScent = BaseScents.valueOf(val);
		this.drops = drops;
	}
	

}
