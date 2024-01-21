import { ApolloServer } from 'apollo-server';
import { schema } from './schema';
import { context } from './context';

export const server = new ApolloServer({ 
    schema: schema, 
    context: context,
    cache: "bounded",
    persistedQueries: false,
    introspection: true
});