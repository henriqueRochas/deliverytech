import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan; // Adicione esta importação

@SpringBootApplication
@ComponentScan(basePackages = "com.deliverytech.delivery.controller") // Adicione esta linha
public class DeliveryApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeliveryApiApplication.class, args);
    }
}