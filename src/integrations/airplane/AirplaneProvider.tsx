import { ReactNode, useRef } from "react";
import { AirplaneGateway } from "../../features/airplane/gateways";

type props = {
    readonly children: ReactNode;
}

export function AirplaneProvider({ children }: props) {
    (window as any).airplaneGateway = useRef(new AirplaneGateway()).current;

    return <>{children}</>
}