package de.com.fdm.service;

import de.com.fdm.grpc.lib.ConsumerGrpc;
import de.com.fdm.grpc.lib.Empty;
import de.com.fdm.grpc.lib.TwitchMessage;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ConsumerServiceImpl extends ConsumerGrpc.ConsumerImplBase {

    @Override
    public void consume(TwitchMessage request, StreamObserver<Empty> responseObserver) {
        String message = String.format(
                "[#%s] %s: %s",
                request.getChannel(),
                request.getName(),
                request.getText());

        System.out.println(message);

        Empty response = Empty.newBuilder().build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
