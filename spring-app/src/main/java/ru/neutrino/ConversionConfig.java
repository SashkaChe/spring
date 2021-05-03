package ru.neutrino;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import ru.neutrino.model.Junior;
import ru.neutrino.model.Senior;

@Configuration
public class ConversionConfig {

	@Bean
	public LocalValidatorFactoryBean validator() {
		return new LocalValidatorFactoryBean();
	}

	@Bean
	public ConversionServiceFactoryBean conversionService() {

		Converter<Junior, Senior> obj = new Converter<Junior, Senior>() {

			@Override
			public Senior convert(Junior source) {
				Senior sen = new Senior();

				sen.setName(source.getName());
				sen.setCompany(source.getCompany());

				return sen;
			}
		};

		ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
		Set<Converter> convs = new HashSet<>();

		convs.add(obj);

		conversionServiceFactoryBean.setConverters(convs);
		conversionServiceFactoryBean.afterPropertiesSet();

		return conversionServiceFactoryBean;
	}

}
