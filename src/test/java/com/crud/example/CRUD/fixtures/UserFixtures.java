package com.crud.example.CRUD.fixtures;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.crud.example.CRUD.user.domain.User;

public class UserFixtures implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(User.class).addTemplate("valid", new Rule() {{
         add("name", "João");
         add("email", "joaooctf@gmail.com");
        }});

        Fixture.of(User.class).addTemplate("invalid", new Rule() {{
            add("name", "");
            add("email", "");
        }});
    }
}
