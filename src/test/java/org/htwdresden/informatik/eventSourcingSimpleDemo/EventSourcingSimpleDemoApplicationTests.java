package org.htwdresden.informatik.eventSourcingSimpleDemo;

import org.htwdresden.informatik.eventSourcingSimpleDemo.event.ArrivalEvent;
import org.htwdresden.informatik.eventSourcingSimpleDemo.event.DepartureEvent;
import org.htwdresden.informatik.eventSourcingSimpleDemo.event.LoadEvent;
import org.htwdresden.informatik.eventSourcingSimpleDemo.event.UnloadEvent;
import org.htwdresden.informatik.eventSourcingSimpleDemo.model.Cargo;
import org.htwdresden.informatik.eventSourcingSimpleDemo.model.Country;
import org.htwdresden.informatik.eventSourcingSimpleDemo.model.Port;
import org.htwdresden.informatik.eventSourcingSimpleDemo.model.Ship;
import org.htwdresden.informatik.eventSourcingSimpleDemo.service.EventProcessor;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.Month;

@SpringBootTest
class EventSourcingSimpleDemoApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(EventSourcingSimpleDemoApplicationTests.class);

	Ship kingOtto;
	Port hamburg, rotterdam, rostock, london;
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

	// added for cargo marking
	@Test
	void visitingUnitedKingdomMarksCargo() {
		testSetup();

		eventProcessor.process(new ArrivalEvent(LocalDate.of(2020,1,10),hamburg, kingOtto));
		eventProcessor.process(new LoadEvent(LocalDate.of(2020,1,11),wheat, kingOtto));
		eventProcessor.process(new DepartureEvent(LocalDate.of(2020,1,12),hamburg, kingOtto));
		eventProcessor.process(new ArrivalEvent(LocalDate.of(2020,1,14),london, kingOtto));
		eventProcessor.process(new DepartureEvent(LocalDate.of(2020,1,15),london, kingOtto));
		eventProcessor.process(new ArrivalEvent(LocalDate.of(2020,1,17),rostock, kingOtto));
		eventProcessor.process(new UnloadEvent(LocalDate.of(2020,1,18),wheat, kingOtto));

		Assert.isTrue(wheat.isHasBeenInUK(), "wheat must have past UK");
	}

	// Setup the test data
	private void testSetup() {
		eventProcessor = new EventProcessor();
		wheat = new Cargo("wheat");
		kingOtto = new Ship("King Otto");
		hamburg = new Port("Hamburg", Country.DE);
		rostock = new Port("Rostock", Country.DE);
		rotterdam = new Port("Rotterdam", Country.NL);
		london = new Port("London", Country.UK);
	}


}
