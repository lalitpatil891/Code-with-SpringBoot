package com.nit.config;

import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.nit.BatchApplication;
import com.nit.entity.Employee;
import com.nit.repository.IEmployeeRepository;

@Configuration
public class AppConfig {

    private final BatchApplication batchApplication;

		@Autowired
		private JobMonitoringListener listener;
		
		@Autowired
		private EmployeeItemProcesser processor;

		@Autowired
		private IEmployeeRepository empRepo;
		
		@Bean(name="ffir")
		public FlatFileItemReader<Employee> createReader(){
			return new FlatFileItemReaderBuilder<Employee>()
					.name("freader")
					.resource(new ClassPathResource("emps_info.csv"))
					.delimited()
					.names("eno", "ename", "eadd","salary")
					.targetType(Employee.class)
					.build();
		}
		
		@Bean(name="riw")
		public RepositoryItemWriter<Employee> createWriter(){
			return new RepositoryItemWriterBuilder<Employee>()
					.repository(empRepo)
					.methodName("save")
					.build();
		}
		
		
		
}
