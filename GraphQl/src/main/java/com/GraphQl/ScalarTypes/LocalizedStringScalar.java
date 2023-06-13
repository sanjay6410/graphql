//package com.GraphQl.ScalarTypes;
//
//import com.commercetools.api.models.common.LocalizedString;
//import com.commercetools.api.models.common.LocalizedStringBuilder;
//
//import graphql.Internal;
//import graphql.schema.Coercing;
//import graphql.schema.CoercingSerializeException;
//import graphql.schema.GraphQLScalarType;
//
//import static graphql.scalars.util.Kit.typeName;
//
//@Internal
//public class LocalizedStringScalar {
//	
//	
//	
//	public LocalizedStringScalar() {}
//	
//	public static final GraphQLScalarType INSTANCE;
//	
//	 static {
//	       Coercing<LocalizedString, String> coercing=new Coercing<LocalizedString, String>() {
//	    	   @Override
//	    	   public String serialize(Object input)throws CoercingSerializeException {
//                  if (input instanceof String) {
//                	  try {
//                		  return LocalizedString.of
//                	  }catch(Exception e) {
//                		  throw new CoercingSerializeException(
//                                  "Expected a valid language tag string but was but was " + typeName(input));
//                	  }
//                  }
//	    	   }
//	    	   
//		};
//		INSTANCE=GraphQLScalarType.newScalar()
//				   .name("LocalizedString")
//				   .description("Localized String of Commerce Tools")
//				   .coercing(coercing)
//	            .build();
//	        }
//
//	
//	
//	
//    
//}
