package Mavsel;

import org.gephi.io.importer.spi.SpigotImporter;
import org.gephi.io.importer.spi.SpigotImporterBuilder;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Pablo Sicilia
 * @version Gephi Mavsel module 1.0
 */
@ServiceProvider(service = SpigotImporterBuilder.class)
public class MavselSpigotBuilder implements SpigotImporterBuilder {

    @Override
    public String getName() {
        return "Mavsel";
    }

    @Override
    public SpigotImporter buildImporter() {
        return new MavselSpigot();
    }
    
    
}
