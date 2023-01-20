package edu.kit.datamanager.semplugin;

import edu.kit.datamanager.mappingservice.plugins.*;
import edu.kit.datamanager.mappingservice.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import java.nio.file.Path;

public class SEMplugin implements IMappingPlugin{
    private final Logger LOGGER = LoggerFactory.getLogger(SEMplugin.class);
    private static final String REPOSITORY = "https://github.com/kit-data-manager/SEM-Mapping-Tool.git";
    private static final String BRANCH = "main";
    private static Path dir;

    @Override
    public String name() {
        return "SEM_Zeiss2";
    }

    @Override
    public String description() {
        return "This python based tool extracts metadata from machine generated scanning microscopy images in the TIFF format.";
    }

    @Override
    public String version() {
        return "0.2.0";
    }

    @Override
    public String uri() {
        return "https://github.com/kit-data-manager/SEM-Mapping-Tool";
    }

    @Override
    public MimeType[] inputTypes() {
        return new MimeType[]{MimeTypeUtils.ALL};
    }

    @Override
    public MimeType[] outputTypes() {
        return new MimeType[]{MimeTypeUtils.ALL};
    }

    @Override
    public void setup() {
        LOGGER.info("Checking and installing dependencies for SEM-Mapping-Tool: ");
        try {
            dir = FileUtil.cloneGitRepository(REPOSITORY, BRANCH);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    @Override
    public MappingPluginState mapFile(Path mappingFile, Path inputFile, Path outputFile) throws MappingPluginException {
        LOGGER.trace("Run SEM-Mapping-Tool on '{}' with mapping '{}' -> '{}'", mappingFile, inputFile, outputFile);
        return PythonRunnerUtil.runPythonScript(dir + "/main/SEM_commandline_script.py", mappingFile.toString(), inputFile.toString(), outputFile.toString());
    }
}
