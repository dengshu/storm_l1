package com.dsmagickey;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.utils.Utils;

import com.dsmagickey.bolt.HelloworldBolt;
import com.dsmagickey.spout.HelloWorldSpout;

public class HellowrldTopology {

	public static void main(String[] args) throws Exception {
		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("send", new HelloWorldSpout(),10);
		builder.setBolt("say", new HelloworldBolt(),2).shuffleGrouping("send");
		Config conf = new Config();
		conf.setDebug(false);
		if(args!=null && args.length>0){
			conf.setNumWorkers(3);
			StormSubmitter.submitTopology(args[0], conf, builder.createTopology());
		}else{
			LocalCluster local = new LocalCluster();
			local.submitTopology("test", conf, builder.createTopology());
			Utils.sleep(1000);
			local.killTopology("test");
			local.shutdown();
		}
	}

}
