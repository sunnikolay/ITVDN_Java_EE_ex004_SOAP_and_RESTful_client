package service;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Main {
	
	public static void main( String[] args ) throws MalformedURLException {
		// URL путь до WSDL сервиса
		URL url = new URL( "http://localhost:8080/ITVDN_Java_EE_ex004_SOAP_and_RESTful_1/TempConverterImplService?wsdl" );

		// Создаем объект Qname, с помощью которого обращаемся к его реализации "TempConverterImplService"...
		// Имя сервиса берем из wsdl файла -> <service name="TempConverterImplService"></service>
        QName qName = new QName( "http://service/", "TempConverterImplService" );
        
        // Создаем сервис
        Service service = Service.create( url, qName );

        // Создаем еще один объект Qname, указываем PORT
        // Имя port берем из <service><port name="TempConverterImplPort"></port><service>
        QName port = new QName("http://service/", "TempConverterImplPort");

        // Запрашиваем методы класса TempConverterImpl(который находится на сервере) через интерфейс TempConverter
        TempConverter tempConverter = service.getPort( port, TempConverter.class );

        System.out.println( tempConverter.c2f(100));
        System.out.println( tempConverter.f2c(218));
        System.out.println( tempConverter.getText( "test call method:" ) );
	}
	
}
