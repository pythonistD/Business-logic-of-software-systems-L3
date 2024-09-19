package cheboksarov.blps_lab3.config;

import cheboksarov.blps_lab3.jobs.PrintMessage;
import cheboksarov.blps_lab3.jobs.ProcessFinishedBetsJob;
import cheboksarov.blps_lab3.service.impl.QuartzServiceImplement;
import org.quartz.JobDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetailFactoryBean printMessageJobDetail(){
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(PrintMessage.class);
        factoryBean.setDurability(true);
        return factoryBean;
    }

    @Bean
    public JobDetailFactoryBean processFinishedBetsJobDetail(){
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(ProcessFinishedBetsJob.class);
        factoryBean.setDurability(true);
        return factoryBean;
    }

    @Bean
    public CronTriggerFactoryBean printMessageTrigger(JobDetail printMessageJobDetail){
        CronTriggerFactoryBean triggerFactoryBean = new CronTriggerFactoryBean();
        triggerFactoryBean.setJobDetail(printMessageJobDetail);
        triggerFactoryBean.setStartDelay(0);
        triggerFactoryBean.setCronExpression("0 0/2 * * * ?");
        return triggerFactoryBean;
    }

    @Bean
    public CronTriggerFactoryBean processFinishedBetsTrigger(JobDetail processFinishedBetsJobDetail){
        CronTriggerFactoryBean triggerFactoryBean = new CronTriggerFactoryBean();
        triggerFactoryBean.setJobDetail(processFinishedBetsJobDetail);
        triggerFactoryBean.setStartDelay(0);
        triggerFactoryBean.setCronExpression("0 0/1 * * * ?");
        return triggerFactoryBean;
    }
}
