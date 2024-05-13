package br.edu.fatec.sjc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class NumberAscOrderTest {

	@Mock
	private CustomStack<Integer> stack;
	
	@InjectMocks
	private NumberAscOrder numberAscOrder;
	
	private Random random;
	
	@BeforeEach
	public void setup(){
		numberAscOrder = new NumberAscOrder(stack);
		random = new Random();
	}
	
	@Test
	public void testSortWithNumbers() throws StackEmptyException {
		List<Integer> randomNumbers = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
            randomNumbers.add(random.nextInt(60) + 1);
        }
		
		for (Integer number : randomNumbers) {
            Mockito.when(stack.pop()).thenReturn(number);
        }
		
		 List<Integer> sortedNumbers = numberAscOrder.sort();

	     randomNumbers.sort(Integer::compareTo);

	     assertEquals(randomNumbers, sortedNumbers);
	     Mockito.verify(stack, Mockito.times(6)).pop();
	     Mockito.verifyNoMoreInteractions(stack);
		}
	
	@Test
    void testSortWithEmptyStack() throws StackEmptyException {
        Mockito.when(stack.isEmpty()).thenReturn(true);

        List<Integer> sortedNumbers = numberAscOrder.sort();

        assertTrue(sortedNumbers.isEmpty());
        Mockito.verify(stack, Mockito.never()).pop();
    }
	
}
