import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SteamMainTests {
    StreamMain sut;

    @Test
    public void testStreamMain(){
        //arrange
        List<Integer> arg = List.of(2, 3, -1, 5, -6, 0, 22);
        //act
        List<Integer> result = sut.streamMain(arg);
        //assert
        assertThat(result, everyItem(greaterThanOrEqualTo(2)));
    }
}
