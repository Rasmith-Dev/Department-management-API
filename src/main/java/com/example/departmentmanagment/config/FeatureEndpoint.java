package com.example.departmentmanagment.config;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "features")
public class FeatureEndpoint {

	private final Map<String, Feature> featureMap = new ConcurrentHashMap<>();

	public FeatureEndpoint() {
		featureMap.put("Department", new Feature(true));
		featureMap.put("user", new Feature(false));
		featureMap.put("authentication", new Feature(false));
	}
	
	@ReadOperation
	public Map<String, Feature> features(){
		return featureMap;
	}
	
	@ReadOperation
	public Feature feature(@Selector String featureName){
		return featureMap.get(featureName);
	}
	
	
	// an inner class feature
	private static class Feature {
		private boolean isEnabled;

		public boolean isEnabled() {
			return isEnabled;
		}

		public void setEnabled(boolean isEnabled) {
			this.isEnabled = isEnabled;
		}

		public Feature(boolean isEnabled) {
			this.isEnabled = isEnabled;
		}

		public Feature() {
		}

		@Override
		public String toString() {
			return "Feature [isEnabled=" + isEnabled + "]";
		}

		@Override
		public int hashCode() {
			return Objects.hash(isEnabled);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Feature other = (Feature) obj;
			return isEnabled == other.isEnabled;
		}

	}

}
