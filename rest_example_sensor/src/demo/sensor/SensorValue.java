package demo.sensor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.Instant;
import java.util.Random;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "battery")

public class SensorValue {
	@XmlElement (name = "capacity")
	public String capacity = "43.2 Wh";

	@XmlJavaTypeAdapter(MyInstantAdapter.class)
	public Instant time;
	public double value;

	public SensorValue() {
		time = Instant.now();
		value = 100;
	}

	public Instant getTime(){
		return time;
	}

		public double getValue(){
		return value;
	}

	public void updateValue() {
        Random random = new Random();
        int randomValue = random.nextInt(5) + 1; // Generates a random value between 1 and 5
        value -= randomValue;
    }

	@Override
	public String toString() {
		return "SensorValue{" +
				"time=" + time +
				", value=" + value +
				'}';
	}
}
