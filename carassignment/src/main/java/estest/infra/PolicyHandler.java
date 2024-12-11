package estest.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import estest.config.kafka.KafkaProcessor;
import estest.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    DispatchRequestRepository dispatchRequestRepository;

    @Autowired
    DispatchStatusRepository dispatchStatusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DispatchRequestCreated'"
    )
    public void wheneverDispatchRequestCreated_DispatchRequestCreationPolicy(
        @Payload DispatchRequestCreated dispatchRequestCreated
    ) {
        DispatchRequestCreated event = dispatchRequestCreated;
        System.out.println(
            "\n\n##### listener DispatchRequestCreationPolicy : " +
            dispatchRequestCreated +
            "\n\n"
        );
        // Comments //
        //배차 신청 생성 시 초기 상태를 업데이트

        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DispatchRequestUpdated'"
    )
    public void wheneverDispatchRequestUpdated_DispatchRequestUpdatePolicy(
        @Payload DispatchRequestUpdated dispatchRequestUpdated
    ) {
        DispatchRequestUpdated event = dispatchRequestUpdated;
        System.out.println(
            "\n\n##### listener DispatchRequestUpdatePolicy : " +
            dispatchRequestUpdated +
            "\n\n"
        );
        // Comments //
        //배차 신청 수정 시 진행 단계 검증 및 상태 업데이트

        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DispatchRequestCancelled'"
    )
    public void wheneverDispatchRequestCancelled_DispatchRequestCancellationPolicy(
        @Payload DispatchRequestCancelled dispatchRequestCancelled
    ) {
        DispatchRequestCancelled event = dispatchRequestCancelled;
        System.out.println(
            "\n\n##### listener DispatchRequestCancellationPolicy : " +
            dispatchRequestCancelled +
            "\n\n"
        );
        // Comments //
        //배차 신청 취소 시 진행 단계 검증 및 취소 처리

        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
