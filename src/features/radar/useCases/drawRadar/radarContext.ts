import { dimensionType } from '../../../../core/cartesianPlane/dimension';
import { radarSettingsType } from '../../models/radarSettings';
import { drawContextType } from '../../ports/drawContext';

export type radarContextType = {
    readonly drawContext: drawContextType;
    readonly dimensions: dimensionType;
    readonly settings: radarSettingsType;
}
