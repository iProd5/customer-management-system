package io.turntabl.customers;

import io.turntabl.customers.v1.Implementors.ClientDAOImpl;
import io.turntabl.customers.v1.Transfers.ClientTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@SpringBootTest
class CustomersApplicationTests {

	@Test
	void testSearchClientByID() {
		String expected = "Test";
		assertEquals(expected,"Test");
	}

}
