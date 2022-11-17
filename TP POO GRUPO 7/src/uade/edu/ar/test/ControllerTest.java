package uade.edu.ar.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uade.edu.ar.dto.ModelDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    LaboratorioController controller;

    @BeforeEach
    public void init() throws Exception {
        controller = LaboratorioController.getInstances();
    }

    @Test
    void getInstances() throws Exception {
        assertNotNull(controller);
    }

    @Test
    void addModel() throws Exception {

        Laboratorio model = new Laboratorio(String.valueOf(Math.random()+4),"name");
        controller.addModel(controller.toDto(model));
    }

    @Test
    void getByIdModel() {
    }

    @Test
    void getAllModel() throws Exception {
        List<ModelDto> list = controller.getAll();
        assertNotEquals(0,list.size());
    }

    @Test
    void deleteByIdModel() {
    }
}