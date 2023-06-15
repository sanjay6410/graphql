package com.GraphQl.ScalarTypes;

import com.commercetools.api.models.common.LocalizedString;

import graphql.Internal;
import graphql.execution.ExecutionStepInfo;
import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.GraphQLScalarType;

@Internal
public class LocalizedStringScalar {
	
	public LocalizedStringScalar() {}
	
	public static final GraphQLScalarType INSTANCE;
	
	DataFetcher localeTag=new DataFetcher<String>() {

		@Override
		public String get(DataFetchingEnvironment environment) throws Exception {
			String languageTag=environment.getArgument("locale");
			return languageTag;
		}
		
	};
	
	private static String getLocaleValue(DataFetchingEnvironment env) {
		ExecutionStepInfo executionStepInfo=env.getExecutionStepInfo();
		String localeValue=executionStepInfo.getArgument("locale");
		System.out.println(localeValue);
		return localeValue;
		
	}
		
	static {
		Coercing<LocalizedString, String> coercing = new Coercing<LocalizedString, String>() {
			
			@Override
			public String serialize(Object input) throws CoercingSerializeException {
				System.out.println("INPUT  "+input);
				
			    if (input instanceof LocalizedString) {
			        try {
			            LocalizedString localizedString = (LocalizedString) input;
			            
//			            String localeTag=getLocaleValue(environment);
			            
			            
			            String value = localizedString.get("en"); // Get the value for the "en" language tag
			            return value != null ? value : ""; // Return the value or an empty string if not found
			        } catch (Exception e) {
			            throw new CoercingSerializeException("Error serializing LocalizedString", e);
			        }
			    }
			    throw new CoercingSerializeException("Expected a LocalizedString object");
			}



			
			@Override
			public LocalizedString parseValue(Object input) {
				throw new UnsupportedOperationException(
						"Can't parse a LocalizedString scalar type from a value.");
			}
			
			@Override
			public LocalizedString parseLiteral(Object input) throws CoercingParseLiteralException {
			    if (input instanceof StringValue) {
			        String value = ((StringValue) input).getValue();
			        try {
			            // Create a LocalizedString instance using the builder pattern
			            LocalizedString localizedString = LocalizedString.builder()
			                    .addValue("en", value) // Set the value for a specific language, here "en" (English)
			                    .build();
			            return localizedString;
			        } catch (Exception e) {
			            throw new CoercingParseLiteralException("Error parsing literal for LocalizedString", e);
			        }
			    }
			    throw new CoercingParseLiteralException("Expected a StringValue for LocalizedString scalar");
			}


		};
		
		INSTANCE = GraphQLScalarType.newScalar()
				.name("LocalizedString")
				.description("Localized String of Commerce Tools")
				.coercing(coercing)
				.build();
	}
}
