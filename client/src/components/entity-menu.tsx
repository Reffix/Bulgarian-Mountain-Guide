import { Menu, MenuItem } from "@material-ui/core";
import { DisplayableEntites, GetIcon } from "../enums/displayable-entities";
import { useState } from "react";
import { useNavigate } from "react-router-dom";


export default function EntityMenu({ mountain, anchorEl, setAnchorEl, handleMainClose }) {

   // const [anchorEl, setAnchorEl] = useState<Element | null>(null);
    const selectedMountain = useNavigate();
  
    const entities = Object.entries(DisplayableEntites);
  
    const mountainInfoOpen = Boolean(anchorEl);
  
    
    return(
        <Menu
            id="basic-menu"
            aria-labelledby="demo-positioned-button"
            anchorEl={anchorEl}
            open={mountainInfoOpen}
            onClose={() => setAnchorEl(null)}
            onMouseLeave={() => setAnchorEl(null)}
        >
            {entities.map((entity) => (
            <MenuItem key={entity.toString()}
                onClick={() => {
                    selectedMountain('/listPage', {
                        state: { mountain: mountain, entity: entity[0] },
                    });
                    setAnchorEl(null);
                    if(handleMainClose) {
                        handleMainClose();
                    }
                }}
            >
                {GetIcon(entity[1])} {entity[1].toString()}
            </MenuItem>
            ))}
        </Menu>
    )
}