import { ReactNode, useRef } from "react";
import { AirplaneGateway } from "../../features/airplane/gateways";
import { AirplaneContext } from "./AirplaneContext";

type props = {
    readonly children: ReactNode;
}

export function AirplaneProvider({ children }: props) {
    const airplaneGateway = useRef(new AirplaneGateway()).current;

    return (
        <AirplaneContext.Provider value={{ airplaneGateway }}>
            {children}
        </AirplaneContext.Provider>
    );
}