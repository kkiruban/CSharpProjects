package logfourj;
import org.apache.logging.log4j.*;


public class Demologfourj {
	
	
    private static Logger log = LogManager.getLogger(Demologfourj.class.getName());
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		log.debug("i am debugging");
		log.info("information");
		log.error("field is not visible");
		log.fatal("fatal error");

	}

}
