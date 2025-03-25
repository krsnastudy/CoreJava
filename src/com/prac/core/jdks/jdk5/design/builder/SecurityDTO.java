package com.prac.core.jdks.jdk5.design.builder;

public class SecurityDTO {
	private final String security;
	private final double priceThreshold;
	private final int volume;

	public SecurityDTO(String security, double priceThreshold, int volume) {
		super();
		this.security = security;
		this.priceThreshold = priceThreshold;
		this.volume = volume;
	}

	public SecurityDTO(SecurityDTOBuilder builder) {
		this.security = builder.security;
		this.priceThreshold = builder.priceThreshold;
		this.volume = builder.volume;
	}

	public String getSecurity() {
		return security;
	}

	public double getPriceThreshold() {
		return priceThreshold;
	}

	public int getVolume() {
		return volume;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(priceThreshold);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((security == null) ? 0 : security.hashCode());
		result = prime * result + volume;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SecurityDTO other = (SecurityDTO) obj;
		if (Double.doubleToLongBits(priceThreshold) != Double.doubleToLongBits(other.priceThreshold))
			return false;
		if (security == null) {
			if (other.security != null)
				return false;
		} else if (!security.equals(other.security))
			return false;
		if (volume != other.volume)
			return false;
		return true;
	}

	public class SecurityDTOBuilder {
		private String security;
		private double priceThreshold;
		private int volume;

		public SecurityDTOBuilder(String security, double priceThreshold, int volume) {
			super();
			this.security = security;
			this.priceThreshold = priceThreshold;
			this.volume = volume;
		}

		public SecurityDTOBuilder() {

		}

		public SecurityDTOBuilder setSecurity(String security) {
			this.security = security;
			return this;
		}

		public SecurityDTOBuilder setThreshold(double priceThreshold) {
			this.priceThreshold = priceThreshold;
			return this;
		}

		public SecurityDTOBuilder setVolume(int volume) {
			this.volume = volume;
			return this;
		}

		public SecurityDTO build() {
			return new SecurityDTO(this);
		}
	}

}
