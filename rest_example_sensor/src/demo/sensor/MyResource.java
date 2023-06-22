package demo.sensor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.time.Instant;

@Path("myresource")
public class MyResource {
	private SensorValue sensorValue = new SensorValue();

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public SensorValue getSensorValue() {
		sensorValue.updateValue();
		return sensorValue;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getSensorValueAsCSV() {
		// Retrieve the time value and format it
		Instant time = sensorValue.getTime();
		String formattedTime = time.toString();

		// Retrieve the value and format it
		double value = sensorValue.getValue();
		String formattedValue = Double.toString(value);

		// Format the data as CSV: <time>,<value>
		String csv = formattedTime + "," + formattedValue;

		return csv;
	}

}
