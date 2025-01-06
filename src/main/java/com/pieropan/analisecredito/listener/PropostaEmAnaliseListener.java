package com.pieropan.analisecredito.listener;

import com.pieropan.analisecredito.domain.Proposta;
import com.pieropan.analisecredito.service.AnaliseCreditoService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class PropostaEmAnaliseListener {


    private AnaliseCreditoService analiseCreditoService;

    @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}")
    public void propostaEmAnalise(Proposta proposta) {
        analiseCreditoService.analisar(proposta);
    }
}


