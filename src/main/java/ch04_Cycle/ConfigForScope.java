package ch04_Cycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import ch04_Cycle.Work.WorkType;

@Configuration
public class ConfigForScope {
@Bean
//@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)
@Scope("prototype")
public Work workProto() {
	Work work = new Work();
	work.setTimeout(2000);
	work.setType(WorkType.SINGLE);
	return work;
}
@Bean
public WorkRunner workRunner() {
	return new WorkRunner();
}
@Bean
public WorkScheduler workScheduler() {
	WorkScheduler scheduler = new WorkScheduler();
	scheduler.setWorkRunner(workRunner());
	return scheduler;
}
}
