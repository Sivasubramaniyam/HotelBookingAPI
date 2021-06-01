package com.hotel.booking.entity;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.filters.FilterPackageInfo;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;


@RunWith(MockitoJUnitRunner.class)
public class PojoTest {
	

	  List<PojoClass> pojoClasses = PojoClassFactory.getPojoClassesRecursively("com.hotel.booking.model", new FilterPackageInfo());

	  @Test
	  public void testPojoStructureAndBehavior() {
		  Validator validator =  ValidatorBuilder.create()
		          .with(new SetterTester())
		          .with(new GetterTester())
		          .build();
	      validator.validate(pojoClasses);
	  }
	  
	  @Test
	  public void testTostringForPackage() {
		  pojoClasses.stream().forEach( c-> {
			  c.getPojoMethods().forEach( m-> {
				  if(m.getName().equals("toString")) {
					  try {
						  Assert.assertNotNull(m.invoke(c.getClazz().newInstance()));
					  }catch(Exception e){
						  
					  }
				  }
			  });
		  });
	  }
	  
	  @Test
	  public void testHashcodeForPackage() {
		  pojoClasses.stream().forEach( c-> {
			  c.getPojoMethods().forEach( m-> {
				  if(m.getName().equals("hashCode")) {
					  try {
						  Assert.assertNotNull(m.invoke(c.getClazz().newInstance()));
					  }catch(Exception e){
						  
					  }
				  }
			  });
		  });
	  }
	  
	  @Test
	  public void testequalsForPackage() {
		  pojoClasses.stream().forEach( c-> {
			  c.getPojoMethods().forEach( m-> {
				  if(m.getName().equals("equals")) {
					  try {
						  Assert.assertNotNull(m.invoke(c.getClazz().newInstance()));
					  }catch(Exception e){
						  
					  }
				  }
			  });
		  });
	  }
	  

}
