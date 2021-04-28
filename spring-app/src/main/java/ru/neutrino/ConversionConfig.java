package ru.neutrino;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;

import ru.neutrino.model.Junior;
import ru.neutrino.model.Senior;

@Configuration
public class ConversionConfig {

	@Bean
	public ConversionServiceFactoryBean conversionService() {

		Converter<Junior, Senior> obj = (n) -> {

			Senior sen = new Senior();

			sen.setName(n.getName());
			sen.setCompany(n.getCompany());

			return sen;

		};

		ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
		Set<Converter> convs = new HashSet<>();

		convs.add(obj);

		conversionServiceFactoryBean.setConverters(convs);
		conversionServiceFactoryBean.afterPropertiesSet();

		return conversionServiceFactoryBean;
	}

}
