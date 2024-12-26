package me.itzg.trymapstructsqids;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import static org.assertj.core.api.Assertions.assertThat;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
@AutoConfigureMockMvc
class TryMapstructSqidsApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testCreate(@Autowired MockMvcTester mvc) {
        assertThat(
            mvc.post().uri("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                    {
                      "name": "test2",
                      "dueDate": "2024-12-24T03:24:35+00:00"
                    }""")
        )
            .hasStatusOk()
            .bodyJson()
            .hasPathSatisfying("$.name", p -> p.assertThat().asString().isEqualTo("test2"))
            .hasPathSatisfying("$.id", p -> p.assertThat().asString().isNotBlank())
            .extractingPath("$.id")
            .asString()
            .satisfies(id -> {
                assertThat(mvc.get().uri("/tasks/{id}", id))
                    .hasStatusOk()
                    .bodyJson()
                    .hasPathSatisfying("$.name", p -> p.assertThat().asString().isEqualTo("test2"));
            });
    }
}
