package org.htwdresden.informatik.eventSourcingSimpleDemo;

import org.htwdresden.informatik.eventSourcingSimpleDemo.event.ArrivalEvent;
import org.htwdresden.informatik.eventSourcingSimpleDemo.event.DepartureEvent;
import org.htwdresden.informatik.eventSourcingSimpleDemo.model.Cargo;
import org.htwdresden.informatik.eventSourcingSimpleDemo.model.Country;
import org.htwdresden.informatik.eventSourcingSimpleDemo.model.Port;
import org.htwdresden.informatik.eventSourcingSimpleDemo.model.Ship;
import org.htwdresden.informatik.eventSourcingSimpleDemo.service.EventProcessor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.Month;

@SpringBootTest
class EventSourcingSimpleDemoApplicationTests {

	Ship kingOtto;
	Port hamburg, rotterdam, rostock;
	Cargo wheat;
	EventProcessor eventProcessor;

	@Test
	void arrivalSetsShipsLocation() {
		testSetup();

		ArrivalEvent arrivalEvent = new ArrivalEvent(LocalDate.of(2020, Month.APRIL, 1), rostock, kingOtto);
		eventProcessor.process(arrivalEvent);
		Assert.isTrue(kingOtto.getPort()==rostock, "port must be rostock");
	}

	@Test
	void departurePutsShipOutToSea() {
		testSetup();

		eventProcessor.process(new ArrivalEvent(LocalDate.of(2020, 2, 10), hamburg, kingOtto));
		eventProcessor.process(new ArrivalEvent(LocalDate.of(2020, 3, 3), rotterdam, kingOtto));
		eventProcessor.process(new DepartureEvent(LocalDate.of(2020, 3, 4), rotterdam, kingOtto));

		Assert.isTrue(Port.AT_SEA == kingOtto.getPort(), "port must be AT_SEA");
	}

	// Setup the test data
	private void testSetup() {
		eventProcessor = new EventProcessor();
		wheat = new Cargo("wheat");
		kingOtto = new Ship("King Otto");
		hamburg = new Port("Hamburg", Country.DE);
		rostock = new Port("Rostock", Country.DE);
		rotterdam = new Port("Rotterdam", Country.NL);
	}


}
