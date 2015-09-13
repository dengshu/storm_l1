package com.dsmagickey.bolt;

import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;

public class HelloworldBolt extends BaseRichBolt {
	private int mycount = 0;
	@Override
	public void prepare(Map stormConf, TopologyContext context,
			OutputCollector collector) {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(Tuple input) {
		String sentence = input.getStringByField("sentence");
		if("Hello world".equals(sentence)){
			mycount++;
			System.out.println("hello world count:" + mycount);
		}else{
//			System.out.println(sentence);
		}
			
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// TODO Auto-generated method stub

	}

}
