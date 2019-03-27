package com.revature.filters;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;

@Component
public class DepthFilter extends SimpleBeanPropertyFilter{
	private final int maxDepth;

	public DepthFilter(int maxDepth) {
		super();
		this.maxDepth = maxDepth;
	}

	private int calcDepth(PropertyWriter writer, JsonGenerator jgen) {
		JsonStreamContext sc = jgen.getOutputContext();
		int depth = -1;
		while (sc != null) {
			sc = sc.getParent();
			depth++;
		}
		return depth;
	}

	@Override
	public void serializeAsField(Object pojo, JsonGenerator gen, SerializerProvider provider, PropertyWriter writer)
			throws Exception {
		int depth = calcDepth(writer, gen);
		if (depth <= maxDepth) {
			writer.serializeAsField(pojo, gen, provider);
		}
		// comment this if you don't want {} placeholders
		else {
			writer.serializeAsOmittedField(pojo, gen, provider);
		}
	}

}
