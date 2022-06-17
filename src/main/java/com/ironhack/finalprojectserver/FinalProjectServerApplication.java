package com.ironhack.finalprojectserver;

import com.ironhack.finalprojectserver.DTO.CalculatorDTO;
import com.ironhack.finalprojectserver.DTO.ClusterDTO;
import com.ironhack.finalprojectserver.DTO.ProjectDTO;
import com.ironhack.finalprojectserver.model.Calculator;
import com.ironhack.finalprojectserver.model.Project;
import com.ironhack.finalprojectserver.model.Role;
import com.ironhack.finalprojectserver.model.User;
import com.ironhack.finalprojectserver.repository.CalculatorRepository;
import com.ironhack.finalprojectserver.service.impl.CalculatorService;
import com.ironhack.finalprojectserver.service.impl.ClusterService;
import com.ironhack.finalprojectserver.service.impl.ProjectService;
import com.ironhack.finalprojectserver.service.impl.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableSwagger2
public class FinalProjectServerApplication {
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectServerApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/**").allowedMethods("*").allowedOrigins("http://localhost:3000");
			}
		};
	}

	@Bean
	CommandLineRunner run(UserService userService, ProjectService projectService,
						  ClusterService clusterService, CalculatorService calculatorService,
						  CalculatorRepository calculatorRepository){
		return args -> {
			userService.saveRole(new Role(1L, "ROLE_TEACHER"));
			userService.saveRole(new Role(2L, "ROLE_STUDENT"));
			userService.saveRole(new Role(3L, "ROLE_ADMIN"));
/*
			userService.saveUser(new User(null, "Raymond", "ray@gmail.com", "P@ssw0rd", new ArrayList<>()));
			userService.saveUser(new User(null, "Shaun", "shaun@gmail.com", "P@ssw0rd", new ArrayList<>()));
			userService.saveUser(new User(null, "Josefina", "jofi@gmail.com", "P@ssw0rd", new ArrayList<>()));

			userService.addRoleToUser("ray@gmail.com", "ROLE_TEACHER");
			userService.addRoleToUser("shaun@gmail.com", "ROLE_TEACHER");
			userService.addRoleToUser("jofi@gmail.com", "ROLE_STUDENT");
			userService.addRoleToUser("ray@gmail.com", "ROLE_ADMIN");*/


			/*calculatorService.setCalculator(new CalculatorDTO("PBE", false, "(1, 1, 1)", 3,
					300, -0.05, 50, 1, 4, "mpirun -np 16 vasp_std"));*/

			/*calculatorService.saveCalculator(new Calculator(1L,"PBE", false, List.of(1, 1, 1), 3,
					300, -0.05, 50, 1, 4, "mpirun -np 16 vasp_std",  new ArrayList<>()));
			calculatorService.saveCalculator(new Calculator(2L,"PBE", false, List.of(1, 1, 1), 3,
					300, -0.05, 100, 1, 4, "mpirun -np 20 vasp_std",  new ArrayList<>()));*/
			/*calculatorService.saveCalculator(new Calculator(3L,"PBE", false, List.of(1, 1, 1), 3,
					300, -0.05, 100, 1, 4, "mpirun ",  new ArrayList<>()));

			calculatorService.saveCalculator(new Calculator(4L,"PBE", false, List.of(1, 1, 1), 3,
					300, -0.05, 100, 1, 4, "1240 vasp_std",  new ArrayList<>()));
*/

			/*Calculator calculator = calculatorService.getCalculatorById(1L);
			Calculator calculator1 = calculatorService.getCalculatorById(2L);*/
			/*Calculator calculator2 = calculatorService.getCalculatorById(3L);
			Calculator calculator3 = calculatorService.getCalculatorById(4L);*/



		/*	projectService.saveProject(new Project(1L, "3|4|Au|Calc1", "description1",
					calculator, new ArrayList<>()));
			projectService.saveProject(new Project(2L, "3|4|Au|Calc2", "description2",
					calculator, new ArrayList<>()));*/

			/*projectService.saveProject(new ProjectDTO( "3|4|Au|Calc1", "description1",
					1L));
			projectService.saveProject(new ProjectDTO("3|4|Au|Calc2", "description2",
					2L));*/

			/*clusterService.saveCluster(new ClusterDTO("3Au", 3, -4.24721533,
					List.of(0.02467511, -0.01682173, 0.01266294,
							0.01547532, 0.00530855, -0.02540933,
							-0.04015043, 0.01151318, 0.01274639),
					0.9999997,1L ));
			clusterService.saveCluster(new ClusterDTO("4Au", 4, -6.24721533,
					List.of(0.02467511, -0.01682173, 0.01266294,
							0.01547532, 0.00530855, -0.02540933,
							0.01547532, 0.00530855, -0.02540933,
							-0.04015043, 0.01151318, 0.01274639),
					0.0,1L ));

			clusterService.saveCluster(new ClusterDTO("3Au", 3, -14.24721533,
					List.of(0.02467511, -0.01682173, 0.01266294,
							0.01547532, 0.00530855, -0.02540933,
							-0.04015043, 0.01151318, 0.01274639),
					0.9999997,2L ));
			clusterService.saveCluster(new ClusterDTO("4Au", 4, -60.24721533,
					List.of(0.02467511, -0.01682173, 0.01266294,
							0.01547532, 0.00530855, -0.02540933,
							0.01547532, 0.00530855, -0.02540933,
							-0.04015043, 0.01151318, 0.01274639),
					0.0,2L ));*/

		};
	}

}