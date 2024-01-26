package zabi.minecraft.nbttooltip.config;

import net.minecraft.client.item.TooltipContext;
import zabi.minecraft.nbttooltip.NBTTooltip;

import java.util.function.Function;

public enum TriggerType {

    F3H(TooltipContext::isAdvanced),
    ALWAYS_ON(ctx -> true),
    TOGGLE_ON_KEY(ctx -> NBTTooltip.nbtKeyToggled),
    SHOW_ON_KEY(ctx -> NBTTooltip.nbtKeyPressed);

    private final Function<TooltipContext, Boolean> test;

    TriggerType(Function<TooltipContext, Boolean> check) {
        this.test = check;
    }

    public boolean shouldShowTooltip(TooltipContext context) {
        return this.test.apply(context);
    }

}
