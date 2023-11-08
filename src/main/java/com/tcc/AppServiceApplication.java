package com.tcc;

import com.tcc.db.CategoriaDAO;
import com.tcc.db.FilmeDAO;
import com.tcc.db.IdiomaDAO;
import com.tcc.db.UsuarioDAO;
import com.tcc.resources.CategoriaResource;
import com.tcc.resources.FilmeResource;
import com.tcc.resources.IdiomaResource;
import com.tcc.resources.UsuarioResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.jersey.jackson.JsonProcessingExceptionMapper;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;

public class AppServiceApplication extends Application<AppServiceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new AppServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "AppService";
    }

    @Override
    public void initialize(final Bootstrap<AppServiceConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<AppServiceConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(AppServiceConfiguration configuration) {
                return configuration.getDatabase();
            }
        });
    }

    @Override
    public void run(final AppServiceConfiguration configuration,
                    final Environment environment) {
        //Database
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDatabase(), "h2");
        FilmeDAO filmeDAO = jdbi.onDemand(FilmeDAO.class);
        //filmeDAO.updateFilmeTable();
        IdiomaDAO idiomaDAO = jdbi.onDemand(IdiomaDAO.class);
        CategoriaDAO categoriaDAO = jdbi.onDemand(CategoriaDAO.class);
        UsuarioDAO usuarioDAO = jdbi.onDemand(UsuarioDAO.class);

        //Resources
        FilmeResource filmeResource = new FilmeResource(filmeDAO);
        IdiomaResource idiomaResource = new IdiomaResource(idiomaDAO);
        CategoriaResource categoriaResource = new CategoriaResource(categoriaDAO);
        UsuarioResource usuarioResource = new UsuarioResource(usuarioDAO);

        environment.jersey().register(filmeResource);
        environment.jersey().register(idiomaResource);
        environment.jersey().register(categoriaResource);
        environment.jersey().register(usuarioResource);

        environment.jersey().register(new JsonProcessingExceptionMapper(true));
    }
}
