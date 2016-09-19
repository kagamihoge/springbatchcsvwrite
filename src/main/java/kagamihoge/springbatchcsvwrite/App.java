package kagamihoge.springbatchcsvwrite;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception, BeansException
    {
        hoge("job/job0001/job001.xml", "csvout1");
        hoge("job/job0002/job002.xml", "csvout2");
    }
    
    
    public static void hoge(String jobxml, String f) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
        ClassPathXmlApplicationContext c = new ClassPathXmlApplicationContext(jobxml);

        JobLauncher j = (JobLauncher)c.getBean("jobLauncher");

        Job job = (Job)c.getBean(f);
        
        Map<String, JobParameter> map = new HashMap<>();
        map.put("key0", new JobParameter("0"));
        JobParameters param = new JobParameters(map);
        
        j.run(job, param);
    }
}
