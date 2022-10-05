import { useContext } from 'react';
import { dimensionType } from '../../core/cartesianPlane/dimension';
import { airplaneType } from '../../features/airplane/models';
import { radarSettingsType } from '../../features/radar/models/radarSettings';
import { RadarContext } from './RadarContext';
import { useRadarStore } from './radarStore';

export function useRadar() {
    const { radarGateway } = useContext(RadarContext);
    const setNumberOfParts = useRadarStore(state => state.setNumberOfParts);
    const setRadarView = useRadarStore(state => state.setRadarView);

    function draw(
        context: CanvasRenderingContext2D,
        dimension: dimensionType,
        airplanes: readonly airplaneType[],
        settings: radarSettingsType,
    ) {
        radarGateway.drawRadar(context, dimension, airplanes, settings);
    }

    function update({ numberOfParts, radarView }: radarSettingsType) {
        setNumberOfParts(numberOfParts);
        setRadarView(radarView);
    }

    return {
        draw,
        update,
    } as const;
}
