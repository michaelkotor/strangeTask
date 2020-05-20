import com.kotor.Instruction;
import com.kotor.sort.SortService;
import com.kotor.util.FileUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.File;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class InstructionTest {
    @InjectMocks
    private Instruction instruction;

    @Mock
    private SortService sortService;

    @Mock
    private FileUtil fileUtil;

    @BeforeEach
    public void setup() {
        initMocks(this);
        instruction.execute();

    }

    @Test
    public void revertContentTest() {
        verify(sortService, times(2)).revertContent(anyList());
    }

    @Test
    public void sortTest() {
        verify(sortService, times(1)).sort(anyList());
    }

    @Test
    public void fileWriteTest() {
        verify(fileUtil, times(1)).writeContentToFile(anyString(), anyList());
    }

    @Test
    public void fileReadTest() {
        verify(fileUtil, times(1)).readContentOfFile(anyString());
    }
}