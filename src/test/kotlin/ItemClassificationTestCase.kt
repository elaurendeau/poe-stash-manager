import com.elaurendeau.itemswap.controller.KeybindController
import com.elaurendeau.itemswap.executionflow.ItemSwapExecutionFlow
import com.elaurendeau.itemswap.utility.ClipboardUtility
import io.mockk.every
import io.mockk.mockkObject
import org.junit.Test

class ItemClassificationTestCase {

    @Test
    fun `testing currency`() {
        val itemData = "Rarity: Currency\n" +
                "Scroll of Wisdom\n" +
                "--------\n" +
                "Stack Size: 40/40\n" +
                "--------\n" +
                "Identifies an item\n" +
                "--------\n" +
                "Right click this item then left click an unidentified item to apply it.\n" +
                "Shift click to unstack."
        val itemSwapExecutionFlow = ItemSwapExecutionFlow()

        mockkObject(ClipboardUtility)
        every { ClipboardUtility.getClipboardData() } returns itemData
        itemSwapExecutionFlow.execute()
    }


    @Test
    fun `testing cards`() {
        val itemData = "Rarity: Divination Card\n" +
                "The Fool\n" +
                "--------\n" +
                "Stack Size: 1/4\n" +
                "--------\n" +
                "20x Orb of Chance\n" +
                "--------\n" +
                "Even the most learned man is a fool to his own fate."

        val itemSwapExecutionFlow = ItemSwapExecutionFlow()

        mockkObject(ClipboardUtility)
        every { ClipboardUtility.getClipboardData() } returns itemData
        itemSwapExecutionFlow.execute()
    }
    @Test
    fun `testing maps`() {
        val itemData = "Rarity: Normal\n" +
                "Superior Underground Sea Map\n" +
                "--------\n" +
                "Map Tier: 2\n" +
                "Atlas Region: Lex Proxima\n" +
                "Item Quantity: +11% (augmented)\n" +
                "Quality: +11% (augmented)\n" +
                "--------\n" +
                "Item Level: 70\n" +
                "--------\n" +
                "Travel to this Map by using it in a personal Map Device. Maps can only be used once."

        val itemSwapExecutionFlow = ItemSwapExecutionFlow()

        mockkObject(ClipboardUtility)
        every { ClipboardUtility.getClipboardData() } returns itemData
        itemSwapExecutionFlow.execute()
    }

}